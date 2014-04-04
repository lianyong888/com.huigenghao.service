package com.huigenghao.service;

import static com.loowj.code.tbean.SysTBColumnTBean.sqlTbName;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.loowj.code.bean.SysTBColumn;
import com.loowj.db.sql.SqlUtil;
import com.loowj.db.util.pub.SqlQuery;

public class TestQueryService {
	protected Log logger = LogFactory.getLog(this.getClass());
	protected SqlUtil sql = new SqlUtil(sqlTbName);
	SqlQuery sqlQuery = new SqlQuery();

	public TestQueryService() {
		System.out.println("123");
	}

	/**
	 * 此处为dao操作，请注意封装service
	 */
	public Collection<SysTBColumn> test() {
		/*SysTb tableView = DB.getInstance().getTable(DB.getInstance().getConnection(), "zh_system", "sys_tb");
		Collection<SysTBColumn> collection = tableView.getColumns();
		return collection;*/
		return null;
	}
}
