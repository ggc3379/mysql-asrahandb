package kr.ac.kumoh.ce.s20220099.mysql_asrahandb

import kr.ac.kumoh.ce.s20220099.mysql_asrahandb.dto.RankerDTO
import org.springframework.stereotype.Service

@Service
class RankerService(private val repository: RankerRepository) {

    fun getAllRankers(): List<Ranker> = repository.findAll()

    fun getAllRankersWithDetails(): List<RankerDTO> = repository.findAllMapped()

    fun getFilteredRankers(
        subclassId: Int?,
        weaponId: Int?,
        setId: Int?
    ): List<RankerDTO> {
        return repository.findFilteredRankers(subclassId, weaponId, setId)
    }
}
