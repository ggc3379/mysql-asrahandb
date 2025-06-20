package kr.ac.kumoh.ce.s20220099.mysql_asrahandb

import org.springframework.stereotype.Service


@Service
class RankerService(val repository: RankerRepository) {
    fun getAllRankers(): List<Ranker> = repository.findAll()
}