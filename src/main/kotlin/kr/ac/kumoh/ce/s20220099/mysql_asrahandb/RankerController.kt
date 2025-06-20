package kr.ac.kumoh.ce.s20220099.mysql_asrahandb


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/rankers")
class RankerController(val rankerService: RankerService) {

    @GetMapping
    fun getAllRankers(): List<Ranker> = rankerService.getAllRankers()
}