package java.com.demo.mms.dao;

import com.demo.mms.common.domain.Admin;


/**
 * @author  teacher
 */
public interface AdminMapper {
    int insert(Admin admin);
    int insertMidreport(Midreport midreport);
}