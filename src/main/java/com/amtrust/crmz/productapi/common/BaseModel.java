package com.amtrust.crmz.productapi.common;

import com.amtrust.crmz.productapi.utils.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class BaseModel {
    @JsonSerialize(using= ObjectIdSerializer.class)
    @Id
    ObjectId _id;
    int deleted = 0;
    Date createdOn = new Date();
    Date updatedOn;
}
