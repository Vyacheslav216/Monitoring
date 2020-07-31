package myProject.config.controller;
import myProject.config.MyData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MyRepository extends CrudRepository<MyData, Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update MyData u set u.Cpu = :cpu, u.Mem = :mem,u.MemD=:memd,u.Freemem=:freemem,u.myID=:myid,u.date=:date where u.id=:id")
    void update(@Param("cpu") float cpu, @Param("mem") float mem,@Param("memd") float memD, @Param("freemem") float freemem ,@Param("myid") int myID,@Param("date") String date,@Param("id") Integer id);

    @Query("SELECT u.Cpu FROM MyData u WHERE u.id=:id")
    String getCPUByID(@Param("id") Integer id);
    @Query("SELECT u.Mem FROM MyData u WHERE u.id=:id")
    String getMEMByID(@Param("id") Integer id);
    @Query("SELECT u.MemD FROM MyData u WHERE u.id=:id")
    String getMEMDByID(@Param("id") Integer id);
    @Query("SELECT u.Freemem FROM MyData u WHERE u.id=:id")
    String getFREEMEMByID(@Param("id") Integer id);
    @Query("SELECT u.date FROM MyData u WHERE u.id=:id")
    String getDATEByID(@Param("id") Integer id);
}