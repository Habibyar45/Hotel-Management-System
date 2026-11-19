CREATE TABLE IF NOT EXISTS guests (

                                      guest_id INTEGER PRIMARY KEY AUTOINCREMENT,

                                      first_name TEXT NOT NULL,

                                      last_name TEXT NOT NULL,

                                      email TEXT UNIQUE,

                                      phone TEXT,

                                      address TEXT,

                                      created_at DATETIME DEFAULT CURRENT_TIMESTAMP

);



CREATE TABLE IF NOT EXISTS rooms (

                                     room_id INTEGER PRIMARY KEY AUTOINCREMENT,

                                     room_number TEXT UNIQUE NOT NULL,

                                     room_type TEXT NOT NULL,

                                     price REAL NOT NULL,

                                     status TEXT NOT NULL

);



CREATE TABLE IF NOT EXISTS reservations (

                                            reservation_id INTEGER PRIMARY KEY AUTOINCREMENT,

                                            guest_id INTEGER NOT NULL,

                                            room_id INTEGER NOT NULL,

                                            check_in DATE NOT NULL,

                                            check_out DATE NOT NULL,

                                            status TEXT NOT NULL,


                                            FOREIGN KEY(guest_id)
    REFERENCES guests(guest_id),


    FOREIGN KEY(room_id)
    REFERENCES rooms(room_id)

    );



CREATE TABLE IF NOT EXISTS invoices (

                                        invoice_id INTEGER PRIMARY KEY AUTOINCREMENT,

                                        reservation_id INTEGER NOT NULL,

                                        amount REAL NOT NULL,

                                        payment_status TEXT NOT NULL,

                                        created_at DATE NOT NULL,


                                        FOREIGN KEY(reservation_id)
    REFERENCES reservations(reservation_id)

    );



CREATE TABLE IF NOT EXISTS users (

                                     user_id INTEGER PRIMARY KEY AUTOINCREMENT,

                                     username TEXT UNIQUE NOT NULL,

                                     password TEXT NOT NULL,

                                     full_name TEXT NOT NULL,

                                     role TEXT NOT NULL

);