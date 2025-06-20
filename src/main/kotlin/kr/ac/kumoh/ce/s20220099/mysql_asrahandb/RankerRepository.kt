package kr.ac.kumoh.ce.s20220099.mysql_asrahandb

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface RankerRepository : JpaRepository<Ranker, Int>