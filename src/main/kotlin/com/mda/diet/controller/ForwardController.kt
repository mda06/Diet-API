package com.mda.diet.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class ForwardController {

    //@RequestMapping(value = ["/**/{[path:[^\\.]*}"])
    fun redirect(): String {
        return "forward:/"
    }
}