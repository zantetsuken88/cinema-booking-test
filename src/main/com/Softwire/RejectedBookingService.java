package com.Softwire;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class RejectedBookingService {
    private static final BookingRequestValidationService bookingRequestValidationService = new BookingRequestValidationService();
    private static final boolean[][] cinema = new boolean[100][50];

    public static int[][] parseBookings(String[] booking) {
        // trim off the closing parenthesis so parseInt doesn't fail
        String raw = booking[2];
        String stripped = raw.substring(0, raw.length() - 1);
        int[] start = rowAndSeat(booking[1].split(":"));
        int[] end = rowAndSeat(stripped.split(":"));
        return new int[][]{start, end};
    }

    private static int[] rowAndSeat(String[] rowSeat) {
        int row = Integer.parseInt(rowSeat[0]);
        int seat = Integer.parseInt(rowSeat[1]);
        return new int[]{row, seat};
    }

    private static boolean validateBooking(int[] start, int[] end) {
        int startRow = start[0];
        int startSeat = start[1];
        int endSeat = end[1];
        if (!bookingRequestValidationService.validateRow(startRow, end[0])) {
            System.out.println("Rejected booking, invalid row selection");
            return false;
        }

        if (!bookingRequestValidationService.validateSeats(startSeat, endSeat)) {
            System.out.println("Rejected booking, invalid seat selection");
            return false;
        }

        // already validated row, so we can assume they are the same
        boolean[] row = cinema[startRow];
        if (!bookingRequestValidationService.validateSingleGaps(row, startSeat, endSeat)) {
            System.out.println("Rejected booking, request would leave single seat empty");
            return false;
        }

        if (!bookingRequestValidationService.validateExistingBookings(row, startSeat, endSeat)) {
            System.out.println("Rejected booking, requested seat already taken");
            return false;
        }
        return true;
    }

    private static void createBooking(int rowReq, int start, int end) {
        for (int i = start; i <= end; i++) {
            cinema[rowReq][i] = true;
        }
    }

    public static File getFile(String filename) throws URISyntaxException {
        ClassLoader classLoader = RejectedBookingService.class.getClassLoader();
        URL resource = classLoader.getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("File not found, check location and try again!: " + filename);
        }
        return new File(resource.toURI());
    }

    public static int processFile(File bookingsFile) {
        int rejections = 0;
        try {
            Scanner scanner = new Scanner(bookingsFile);
            while (scanner.hasNext()) {
                String[] booking = scanner.nextLine().split(",");
                int[][] parsed = parseBookings(booking);
                boolean isValid = validateBooking(parsed[0], parsed[1]);
                if (isValid) {
                    createBooking(parsed[0][0], parsed[0][1], parsed[1][1]);
                } else {
                    rejections++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.print("Something went wrong locating the file. Check the name and try again");
        }
        return rejections;
    }

    public static void main(String[] args) throws Exception {
        try {
            File bookingFile = getFile("resources/booking_requests");
            int rejections = processFile(bookingFile);
            System.out.printf("Finished processing bookings. Rejected [%s] bookings!", rejections);
        } catch (Exception e) {
            throw new Exception("Oops, something's gone wrong.", e);
        }
    }
}
