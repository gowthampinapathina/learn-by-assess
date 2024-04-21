package com.stackroute.adminservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id",
scope = Batch.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Batch implements Serializable
{
    private String batchId;
    private String batchName;
    private String instructorName;
    private String instructorMail;
    private List<Learner> learner;  //list of the learner object


}
