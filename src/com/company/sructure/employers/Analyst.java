package com.company.sructure.employers;

import com.company.sructure.Task;
import com.company.sructure.employers.devTypes.DevType;
import com.company.sructure.Status;

import java.util.List;
import java.util.Random;

public class Analyst extends Employer {


    public Analyst(String name) {
        super(name);
    }

    public void generateTask(List<Task> tasks, int n, int deadline){

        Random random = new Random();

        //String name = random.nextInt(10) + "." + (random.nextInt(10)) + "." + (random.nextInt(10));//продумать генерацию имен, чтобы не повторялись (проверка в tasks)
        // список строк для генерации имен -- первые пять название, осатльное описание
        String description = "Сделай или сдохни / do or die / место для вашей рекламы"; // продумать генерацию описания. Массив слов в случайной последовательности?
        int devTime = random.nextInt(10)+1;
   //     devTime = performance;

        //DevType devType = DevType.randomType (random.nextInt());
        DevType devType = DevType.ANDROID;
        //int priority = random.nextInt();
        int priority = 1;


        tasks.add(new Task(""+n,description,devTime,devType,priority, Status.OPEN,deadline,this));

    }



}
