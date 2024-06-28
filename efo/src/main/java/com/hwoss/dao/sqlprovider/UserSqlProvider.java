package com.hwoss.dao.sqlprovider;

import com.hwoss.EfoApplication;
import com.hwoss.modules.constant.ConfigConsts;
import com.hwoss.modules.constant.DefaultValues;
import com.zhazhapan.util.Checker;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author admin
 * @since  
 */
public class UserSqlProvider {

    public String updateAuthById() {
        return CommonSqlProvider.updateAuthById("user");
    }

    public String getUserBy(@Param("permission") int permission, @Param("condition") String condition, @Param
            ("offset") int offset) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("user");
            if (permission == DefaultValues.THREE_INT) {
                WHERE("permission<3");
            } else if (permission == DefaultValues.TWO_INT) {
                WHERE("permission<2");
            } else {
                WHERE("permission<0");
            }
            if (Checker.isNotEmpty(condition)) {
                WHERE("username like '%" + condition + "%' or email like '%" + condition + "%' or real_name like '" +
                        condition + "'");
            }
            ORDER_BY(EfoApplication.settings.getStringUseEval(ConfigConsts.USER_ORDER_BY_OF_SETTINGS));
        }}.toString();
        int size = EfoApplication.settings.getIntegerUseEval(ConfigConsts.USER_PAGE_SIZE_OF_SETTINGS);
        return sql + " limit " + (offset * size) + "," + size;
    }
}
