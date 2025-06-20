package kr.ac.kumoh.ce.s20220099.mysql_asrahandb

import kr.ac.kumoh.ce.s20220099.mysql_asrahandb.dto.RankerDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RankerRepository : JpaRepository<Ranker, Int> {

    @Query("""
    SELECT new kr.ac.kumoh.ce.s20220099.mysql_asrahandb.dto.RankerDTO(
        r.rankerId,
        r.nickname,
        r.fame,
        s.subclassName,
        s.jobGroup,
        w.weaponName,
        w.weaponType,
        w.legacyType,
        e.setName
    )
    FROM Ranker r
    JOIN Subclass s ON r.subclassId = s.subclassId
    JOIN Weapon w ON r.weaponId = w.weaponId
    JOIN EquipmentSet e ON r.setId = e.setId
    ORDER BY r.fame DESC
""")
    fun findAllMapped(): List<RankerDTO>

    @Query("""
    SELECT new kr.ac.kumoh.ce.s20220099.mysql_asrahandb.dto.RankerDTO(
        r.rankerId,
        r.nickname,
        r.fame,
        s.subclassName,
        s.jobGroup,
        w.weaponName,
        w.weaponType,
        w.legacyType,
        e.setName
    )
    FROM Ranker r
    JOIN Subclass s ON r.subclassId = s.subclassId
    JOIN Weapon w ON r.weaponId = w.weaponId
    JOIN EquipmentSet e ON r.setId = e.setId
    WHERE (:subclassId IS NULL OR r.subclassId = :subclassId)
      AND (:weaponId IS NULL OR r.weaponId = :weaponId)
      AND (:setId IS NULL OR r.setId = :setId)
    ORDER BY r.fame DESC
""")
    fun findFilteredRankers(
        @Param("subclassId") subclassId: Int?,
        @Param("weaponId") weaponId: Int?,
        @Param("setId") setId: Int?
    ): List<RankerDTO>


}
