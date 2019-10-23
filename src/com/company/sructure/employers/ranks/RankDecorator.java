package com.company.sructure.employers.ranks;

import com.company.sructure.employers.EmpType;
import com.company.sructure.employers.Employer;
import com.company.sructure.employers.EmployerInterface;


public abstract class RankDecorator extends Employer implements EmployerInterface {

 EmployerInterface employer;



 public RankDecorator(EmployerInterface employer) {
  super();
  this.employer = employer;
 }

 @Override
 public String getName() {
  return employer.getName();
 }

 @Override
 public EmpType getEmpType() {
  return employer.getEmpType();
 }

 @Override
 public Rank getRank() {
  return super.getRank();
 }

 @Override
 public void setRank(Rank rank) {
  super.setRank(rank);
 }



 //@Override
    //public DevType getDevType() {
   //     return null;
   // }
}
