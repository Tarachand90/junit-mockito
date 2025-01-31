package com.tc.doubles.fake;


import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String title;
    private String bookId;
    private int price;
    private LocalDate publishDate;

}
