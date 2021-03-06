/**
 * Copyright (c) 2011-2023, James Zhan 詹波 (jfinal@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jfinal.plugin.activerecord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * SqlPara
 * 封装查询使用的 sql 与参数，主要用于 getSqlPara(...) 返回值
 */
public class SqlPara implements Serializable {
	
	private static final long serialVersionUID = -8586448059592782381L;
	
	String sql;
	List<Object> paraList;
	
	public SqlPara setSql(String sql) {
		this.sql = sql;
		return this;
	}
	
	public SqlPara addPara(Object para) {
		if (paraList == null) {
			paraList = new ArrayList<Object>();
		}
		paraList.add(para);
		return this;
	}
	
	public String getSql() {
		return sql;
	}
	
	public Object[] getPara() {
		if (paraList == null || paraList.size() == 0) {
			return DbKit.NULL_PARA_ARRAY;
		} else {
			return paraList.toArray(new Object[paraList.size()]);
		}
	}
	
	public SqlPara clear() {
		sql = null;
		if (paraList != null) {
			paraList.clear();
		}
		return this;
	}
	
	public String toString() {
		return "Sql: " + sql + "\nPara: " + paraList;
	}
}
