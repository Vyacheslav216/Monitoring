package myProject.config;

import javax.persistence.*;

@Entity
public class MyData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private float Cpu,Mem,MemD,Freemem;
    private int myID;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMyID() {
        return myID;
    }

    public float getCpu() {
        return Cpu;
    }

    public float getFreemem() {
        return Freemem;
    }

    public void setFreemem(float freemem) {
        Freemem = freemem;
    }

    public void setCpu(float cpu) {
        Cpu = cpu;
    }

    public float getMem() {
        return Mem;
    }

    public void setMem(float mem) {
        Mem = mem;
    }

    public float getMemD() {
        return MemD;
    }

    public void setMemD(float memD) {
        MemD = memD;
    }

    public void setAll(float cpu, float mem, float memD,float freemem ,int myID,String date)
    {
        this.Cpu=cpu;
        this.Mem = mem;
        this.MemD=memD;
        this.myID=myID;
        this.Freemem=freemem;
        this.date=date;

    }

    @Override
    public String toString() {
        return "MyData{" +
                "id=" + id +
                ", Cpu=" + Cpu +
                ", Mem=" + Mem +
                ", MemD=" + MemD +
                ", Freemem=" + Freemem +
                ", myID=" + myID +
                ", date='" + date + '\'' +
                '}';
    }
}
