package com.restdao.food.app;

import java.util.List;

import com.rest.food.app.rest;

public interface restdao {
	List<rest> getresta();
	rest getrestaId(int restid);
	void addresta(rest r);
	void updateresta(rest r);
	void deleteresta(int  restaid);

}
