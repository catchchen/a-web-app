package zx.app.web.service.inter;

import zx.app.web.model.Response;
import zx.app.web.model.SortFormParam;

/**
 * @author chenk
 * @description 功能
 */
public interface SortService {


    Response add(SortFormParam sortParam);

    Response remove(Integer id);
}
