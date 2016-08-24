package service.comand;

import javax.naming.Context;
import java.util.Map;

public interface Command {

    Object execute(Context context, Map<String,Object> params);
}
