package zx.app.web.controller.api;

import org.springframework.web.bind.annotation.*;
import zx.app.web.model.Response;
import zx.app.web.model.SortFormParam;
import zx.app.web.service.inter.SortService;

/**
 * @author chenk
 */

@RestController
@RequestMapping("/user/article/sorts")
public class SortController {
    private final SortService sortService;
    public SortController(SortService sortService){
        this.sortService = sortService;
    }
    @PostMapping
    public Response create(@RequestBody SortFormParam sortParam){


        return Response.ok("添加成功");
    }

    @DeleteMapping("/{sortId}")
    public Response delete(@PathVariable("sortId") Integer id){

        return Response.fail();
    }

}
