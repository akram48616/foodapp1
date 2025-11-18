package com.menudao;

import java.util.List;

import com.menu.menu;

public interface menudao {
	List<menu> getmenu();
	menu getmenuId(int menuid);
	void addmenu(menu m);
	List<menu> getMenuByRestaid(int restaid);
	void updatemenu(menu m);
	void deletermenu(int  menuid);

}
