package com.cj.hafter.entity;

import com.cj.core.utils.excle.IsNeeded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by JuLei on 2019/8/15.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleInfo {
    @IsNeeded
    private String id;
    @IsNeeded
    private String type1;
    @IsNeeded
    private String type2;
    @IsNeeded
    private String type3;
    @IsNeeded
    private String manufacturer;
    @IsNeeded
    private String sort;

}
