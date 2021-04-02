package com.Softwire;

public class BookingRequestValidationService {
    boolean validateRow(int startRow, int endRow) {
        return (startRow == endRow) && (startRow <= 99);
    }

    boolean validateSeats(int startSeat, int endSeat) {
        int highestSeat = Math.max(startSeat, endSeat);

        // Only 50 seats in a row
        if (highestSeat > 49) {
            return false;
        }

        int seatQuantity = highestSeat == endSeat
                ? (endSeat - startSeat) + 1
                : (startSeat - endSeat) + 1;

        return seatQuantity <= 5;
    }

    boolean validateSingleGaps(boolean[] row, int start, int end) {
        // if start == 0 then no single gap can be left. request is valid
        // if start == 1 then seat 0 must be true (already booked), or else it will be invalid
        // if start > 1 then: if start -1 = true. Request is valid. If false, start -2 must also be false.
        boolean validAtStart;
        if (start == 0) {
            validAtStart = true;
        } else if (start == 1) {
            validAtStart = row[0];
        } else {
            validAtStart = row[start - 1] || !row[start - 2];
        }
        // if end == 49 then no single gap can be left. request is valid
        // if end == 48 then seat 49 must be true (already booked), or else it will be invalid
        // if end < 48 then: if end +1 = true. Request is valid. If false, start +2 must also be false.
        boolean validAtEnd;
        if (end == 49) {
            validAtEnd = true;
        } else if (end == 48) {
            validAtEnd = row[49];
        } else {
            validAtEnd = row[end + 1] || !row[end + 2];
        }
        return validAtStart && validAtEnd;
    }

    boolean validateExistingBookings(boolean[] row, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (row[i]) {
                return false;
            }
        }
        return true;
    }
}
