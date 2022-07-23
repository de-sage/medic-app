package com.thriveagric.medicapp.repository;

import com.thriveagric.medicapp.models.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
    Optional<Diagnosis> findTopByOrderByDiagnosisDateDesc();

    //Custom query
//    @Query(value = "select * from shop s where s.owner_name like %:keyword% or s.shop_type like %:keyword%", nativeQuery = true)
//    List<Shop> findByKeyword(@Param("keyword") String keyword);

    List<Diagnosis> findByIsValidTrue();

    List<Diagnosis> findByIsValidFalse();

}
