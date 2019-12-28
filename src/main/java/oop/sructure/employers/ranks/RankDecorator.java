package oop.sructure.employers.ranks;

import oop.sructure.employers.employer.EmpType;
import oop.sructure.employers.employer.EmployerImpl;
import oop.sructure.employers.employer.Employer;


public abstract class RankDecorator extends EmployerImpl implements Employer {

 Employer employer;



 public RankDecorator(Employer employer) {
  super();
  this.employer = employer;
 }

 @Override
 public String getNameEmployer() {
  return employer.getNameEmployer();
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
