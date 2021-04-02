# Tech Test for Softwire - Cinema Bookings

### To Run:
- The project isn't set up to compile to a .jar (and due to the way the file is detected it would probably need modification to do so).
- Simply clone the repo and open in IDE (I used IntelliJ to write and there are some generated files committed which may or may not be helpful.)
- Run `src/main/com.Softwire/RejectedBookingService.java` to see output. 
- In order to run against a different set of inputs, a similarly formatted csv file can be dropped into `src/main/resources` and the filename can be replaced on line 107 of `RejectedBookingService`.
- Tests are located at `src/test/com.Softwire/`
- Please do get in touch if there any issues running the code, or if you'd like to give me any feedback :)

### Brief:
The problem is as follows:

A cinema has a theatre of 100 rows, each with 50 seats. Customers request particular seats when making a booking. Bookings are processed on a first-come, first-served basis. A booking is accepted as long as it is for five or fewer seats, all seats are adjacent and on the same row, all requested seats are available, and accepting the booking would not leave a single-seat gap (since the cinema believes nobody would book such a seat, and so loses the cinema money).

Write a system to process a text file of bookings (booking_requests) and determine the number of bookings which are rejected. To test your system, a smaller sample file (sample_booking_requests) is supplied; processing this file should yield 10 rejected requests.

The text file of bookings contains one booking per line, where a booking is of the following form:

`(<id>,<index of first seat row>:<index of first seat within row>,<index of last seat row>:<index of last seat within row>),`

Rows and seats are both 0-indexed. Note the trailing comma is absent on the final line.

## Final Output
- Total Requests: 2202
- Successful bookings: 2164
- Rejected bookings: 38

- I wrote an additional function to print a visualisation of the seating arrays which I've copied below. (Mostly because I was concerned about the shockingly low number of rejections in such a large selection of bookings.)

```
X  X  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  
O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  X  X  
O  X  X  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  
O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  O  X  X  
O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  
O  O  O  X  X  O  O  X  X  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  X  X  O  X  X  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  
O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  
O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  
O  X  X  O  O  X  X  O  O  O  O  X  X  O  X  X  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  
X  X  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  X  X  
O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  X  X  O  X  X  O  O  O  O  O  O  X  X  
X  X  O  O  O  O  O  O  O  O  X  X  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  O  O  O  O  O  O  X  X  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  
X  X  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  X  X  O  X  X  O  
X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  X  X  
X  X  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  O  O  O  O  O  O  X  X  O  O  X  X  
X  X  O  O  O  O  O  O  O  O  O  O  X  X  O  X  X  O  O  O  O  O  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  X  X  
X  X  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  
O  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  X  X  O  X  X  O  X  X  O  O  X  X  O  O  O  O  X  X  O  
O  X  X  O  X  X  O  O  O  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  
X  X  O  O  O  O  O  X  X  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  X  X  
O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  
O  X  X  O  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  X  X  
X  X  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  X  X  O  
O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  
O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  
O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  O  O  O  O  O  O  O  O  X  X  O  
O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  O  O  X  X  O  X  X  O  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  X  X  O  O  O  O  O  X  X  
O  X  X  O  O  O  O  O  O  X  X  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  X  X  O  X  X  
O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  X  X  
X  X  O  O  X  X  O  O  X  X  O  X  X  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  X  X  
X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  
X  X  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  
X  X  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  X  X  
O  O  X  X  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  X  X  O  X  X  O  X  X  
O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  X  X  O  X  X  
O  O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  
X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  
O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  O  O  O  O  O  X  X  O  O  O  X  X  
X  X  O  X  X  O  O  O  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  X  X  
X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  
X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  X  X  O  X  X  O  X  X  O  O  X  X  O  O  O  X  X  O  X  X  
X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  
O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  O  O  X  X  
X  X  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  X  X  O  O  X  X  O  O  
O  X  X  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  
O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  O  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  
X  X  O  X  X  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  
O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  X  X  O  X  X  O  O  O  X  X  
X  X  O  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  X  X  
X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  X  X  O  X  X  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  
O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  X  X  O  X  X  
O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  X  X  
O  O  O  X  X  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  X  X  
O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  X  X  O  
X  X  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  X  X  O  O  X  X  O  O  O  O  O  O  X  X  O  O  X  X  
X  X  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  
X  X  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  
O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  X  X  O  O  X  X  O  O  X  X  
X  X  O  O  O  O  X  X  O  X  X  O  O  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  O  X  X  O  
O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  X  X  O  X  X  O  O  X  X  
X  X  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  
O  O  X  X  O  O  X  X  O  O  O  O  O  O  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  
X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  
O  X  X  O  O  O  O  O  O  X  X  O  O  X  X  O  X  X  O  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  X  X  
O  O  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  
O  X  X  O  X  X  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  
O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  X  X  
O  X  X  O  O  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  
X  X  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  X  X  O  
O  O  X  X  O  X  X  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  
X  X  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  X  X  O  O  
X  X  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  X  X  
O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  
O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  
X  X  O  O  X  X  O  O  X  X  O  O  X  X  O  O  X  X  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  O  O  O  O  X  X  O  O  
O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  
O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  O  O  O  O  X  X  O  O  X  X  O  
X  X  O  O  O  X  X  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  X  X  
X  X  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  X  X  O  O  
X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  X  X  O  X  X  O  
O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  O  O  
O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  X  X  
X  X  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  X  X  O  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  
O  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  O  O  X  X  
X  X  O  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  X  X  
O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  X  X  O  X  X  O  X  X  O  X  X  O  X  X  
O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  X  X  O  O  O  O  O  X  X  O  O  
X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  
X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  O  X  X  O  O  O  X  X  O  O  O  O  O  O  O  X  X  
X  X  O  O  O  O  X  X  O  X  X  O  X  X  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  X  X  O  X  X  O  O  O  X  X  
O  X  X  O  O  X  X  O  X  X  O  X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  
X  X  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  O  O  O  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  
O  O  O  O  X  X  O  O  O  X  X  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  O  X  X  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  O  O  X  X  O  
O  O  X  X  O  O  O  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  X  X  O  O  O  X  X  O  X  X  O  O  O  X  X  O  X  X  O  
O  X  X  O  O  O  O  O  X  X  O  X  X  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  O  X  X  O  O  X  X  O  
O  X  X  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  X  X  O  X  X  O  O  X  X  O  O  
O  X  X  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  X  X  O  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  
X  X  O  O  O  O  O  X  X  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  X  X  O  O  O  O  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  
O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  O  X  X  O  O  X  X  O  O  X  X  O  O  O  O  O  X  X  O  
O  O  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  O  X  X  O  O  O  O  O  X  X  O  O  O  O  O  O  O  O  X  X  O  O  O  O  O  O  O  X  X
```
