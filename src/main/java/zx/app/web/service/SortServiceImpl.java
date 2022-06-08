package zx.app.web.service;

import org.springframework.stereotype.Service;
import zx.app.web.mapper.SortMapper;
import zx.app.web.model.Response;
import zx.app.web.model.SortFormParam;
import zx.app.web.model.entity.Sort;
import zx.app.web.service.inter.SortService;

/**
 * @author chenk
 */
@Service
public class SortServiceImpl implements SortService {

    private final SortMapper sortMapper;
    public SortServiceImpl( SortMapper sortMapper ) {
        this.sortMapper = sortMapper;
    }
    @Override
    public Response add(SortFormParam sortParam) {
        // logic
        return Response.ok("添加成功");
    }

    @Override
    public Response remove(Integer id) {

        // logic

        return Response.ok("success");
    }

}
