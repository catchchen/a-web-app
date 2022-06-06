package zx.app.web.service;

import org.springframework.stereotype.Service;
import zx.app.web.model.Response;
import zx.app.web.model.SortFormParam;
import zx.app.web.model.entity.Sort;
import zx.app.web.service.inter.SortService;

/**
 * @author chenk
 */
@Service
public class SortServiceImpl implements SortService {

    @Override
    public Response add(SortFormParam sortParam) {
        return Response.ok("添加成功");
    }

}
