package zx.app.web.controller.api;

import org.springframework.web.bind.annotation.*;
import zx.app.web.model.Response;
import zx.app.web.model.SortFormParam;
import zx.app.web.service.inter.SortService;

import java.util.ArrayList;

/**
 * @author chenk
 */

@RestController
@RequestMapping("api/user/")
public class SortController {
    private final SortService sortService;
    public SortController(SortService sortService){
        this.sortService = sortService;
    }
    @PostMapping("sorts")
    public Response create(@RequestBody SortFormParam sortParam){
        // 创建分类
        return sortService.add(sortParam);
    }
    @GetMapping("sorts")
    public Response getSorts(){
        ArrayList<String> sortNames = new ArrayList<>();
        return Response.ok(sortNames);
    }
    @PutMapping("sorts/{sortId}")
    public Response modifySorts(@PathVariable("sortId") Integer id){
//        sortService.updateSort(id);
        return Response.ok("修改成功");
    }

    @DeleteMapping("sorts/{sortId}")
    public Response delete(@PathVariable("sortId") Integer id){

        return sortService.remove(id);
    }

}
