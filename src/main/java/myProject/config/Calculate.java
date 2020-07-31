package myProject.config;

import myProject.config.controller.MyRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Calculate {
    public static Object[][] calcCPU(List<MyData>data) {


        Object[][] mass = new Object[62][2];

        mass[0][0]="Time";
        mass[0][1]="CPU";
        int i=1;
        for(MyData d :data) {
            mass[i][0]=d.getDate();

            mass[i][1]=Float.valueOf(d.getCpu());
            i++;
            }



        return mass;
    }
    public static float calcAVGCPU(List<MyData>data)
    {
        float avg=0;
        int i=0;
        for(MyData d :data) {
                avg += d.getCpu();
            i++;
        }
        return avg/i;
    }
    public static Object[][] calcRAM(List<MyData>data)
    {

        Object[][] mass = new Object[62][2];

        mass[0][0]="Time";
        mass[0][1]="RAM";
        int i=1;


        for(MyData d :data) {

                //   cal.add(Calendar.MINUTE, 1); //minus number would decrement the days
                //   System.out.println(ft.format(cal.getTime()));
                mass[i][0]=d.getDate();
                mass[i][1]=Float.valueOf(d.getMemD());
                i++;

        }
        return mass;
    }
    public static float calcAVGRAM(List<MyData>data)
    {
        float avg=0;
        int i=0;
        for(MyData d :data) {
            avg += d.getMemD();
            i++;
        }
        return avg/i;
    }
    public static Object[][] calcDISCLoad(List<MyData>data)
    {

        Object[][] mass = new Object[62][2];

        mass[0][0]="Time";
        mass[0][1]="Load";
        int i=1;

        for(MyData d :data) {

                //   cal.add(Calendar.MINUTE, 1); //minus number would decrement the days
                //   System.out.println(ft.format(cal.getTime()));
                mass[i][0]=d.getDate();
                mass[i][1]=Float.valueOf(d.getMem());

            i++;

        }
        return mass;
    }
    public static float calcAVGDISC(List<MyData>data)
    {
        float avg=0;
        int i=0;
        for(MyData d :data) {
                avg += d.getMem();
            i++;
        }
        return avg/i;
    }
    public static Object[][] calcDISCFreeSpace(List<MyData>data)
    {

        Object[][] mass = new Object[62][2];

        mass[0][0]="Time";
        mass[0][1]="USED Space";
        int i=1;

        for(MyData d :data) {
                //   cal.add(Calendar.MINUTE, 1); //minus number would decrement the days
                //   System.out.println(ft.format(cal.getTime()));
                mass[i][0]=d.getDate();
                mass[i][1]=Float.valueOf(d.getFreemem());

            i++;

        }
        return mass;
    }
    public static Object[][] calcALL(List<MyData>data)
    {
        Object[][] mass = new Object[62][5];

        mass[0][0]="Time";
        mass[0][1]="CPU";
        mass[0][2]="RAM";
        mass[0][3]="DISC Used Space";
        mass[0][4]="DISC Load";
        int i=1;
        System.out.println(data.size());
        for(MyData d :data) {

                //   cal.add(Calendar.MINUTE, 1); //minus number would decrement the days
                //   System.out.println(ft.format(cal.getTime()));
                mass[i][0]=d.getDate();
                mass[i][1]=Float.valueOf(d.getCpu());
                mass[i][2]=Float.valueOf(d.getMemD());
                mass[i][3]=Float.valueOf(d.getFreemem());
                mass[i][4]=Float.valueOf(d.getMem());


            i++;

        }
        return mass;
    }
    public static  List<MyData> set(int id, MyRepository repo)
    {

    List<MyData> data=new ArrayList<>();

    for(int i=id-60;i<id;i++)
    {
        MyData d=new MyData();
        d.setCpu(Float.parseFloat(repo.getCPUByID(i)));
        d.setMem(Float.parseFloat(repo.getMEMByID(i)));
        d.setMemD(Float.parseFloat(repo.getMEMDByID(i)));
        d.setDate(repo.getDATEByID(i));
        d.setFreemem(Float.parseFloat(repo.getFREEMEMByID(i)));
        data.add(d);
    }
    return data;
    }

}
