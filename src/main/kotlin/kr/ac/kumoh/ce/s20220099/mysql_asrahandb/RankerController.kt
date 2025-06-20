package kr.ac.kumoh.ce.s20220099.mysql_asrahandb

import kr.ac.kumoh.ce.s20220099.mysql_asrahandb.dto.RankerDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rankers")
class RankerController(private val rankerService: RankerService) {

    // 외래키 id 값만 가진 단순 조회 (Ranker 엔티티 전체 리스트)
    @GetMapping("/simple")
    fun getAllRankers(): List<Ranker> = rankerService.getAllRankers()

    // 조인된 상세정보를 DTO로 조회
    @GetMapping("/detailed")
    fun getAllRankersWithDetails(): List<RankerDTO> = rankerService.getAllRankersWithDetails()

    // 필터링된 상세정보 조회 (쿼리 파라미터로 id 전달)
    @GetMapping("/filter")
    fun getFilteredRankers(
        @RequestParam subclassId: Int?,
        @RequestParam weaponId: Int?,
        @RequestParam setId: Int?
    ): List<RankerDTO> {
        return rankerService.getFilteredRankers(subclassId, weaponId, setId)
    }
}

