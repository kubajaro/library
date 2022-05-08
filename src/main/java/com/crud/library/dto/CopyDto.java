package com.crud.library.dto;

import com.crud.library.enumvalues.CopyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CopyDto {
    private int id;
    private int bookId;
    private CopyStatus status;
}
