package com.teamproject.gaxga.repository.gabojago;

import com.teamproject.gaxga.entity.gabojago.GP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GpRepository extends JpaRepository<GP, Long> {
    @Query(value = "SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid", nativeQuery = true)
    List<String> findAllNames();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=1", nativeQuery = true)
    List<String> findAllNamesByGangwon();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=2", nativeQuery = true)
    List<String> findAllNamesByGyeonggi();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=3", nativeQuery = true)
    List<String> findAllNamesByGyeongnam();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=4", nativeQuery = true)
    List<String> findAllNamesByGyeongbuk();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=5", nativeQuery = true)
    List<String> findAllNamesByGwangju();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=6", nativeQuery = true)
    List<String> findAllNamesByDaegu();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=7", nativeQuery = true)
    List<String> findAllNamesByDaejeon();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=8", nativeQuery = true)
    List<String> findAllNamesByBusan();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=9", nativeQuery = true)
    List<String> findAllNamesBySeoul();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=10", nativeQuery = true)
    List<String> findAllNamesBySejong();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=11", nativeQuery = true)
    List<String> findAllNamesByUlsan();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=12", nativeQuery = true)
    List<String> findAllNamesByIncheon();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=13", nativeQuery = true)
    List<String> findAllNamesByJeonnam();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=14", nativeQuery = true)
    List<String> findAllNamesByJeonbuk();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=15", nativeQuery = true)
    List<String> findAllNamesByJeju();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=16", nativeQuery = true)
    List<String> findAllNamesByChungnam();

    @Query(value ="SELECT R.name, T.name, P.name FROM GP P JOIN GR R ON R.GRid = P.GRid JOIN GT T ON T.GTid = P.GTid WHERE R.GRid=17", nativeQuery = true)
    List<String> findAllNamesByChungbuk();
}
