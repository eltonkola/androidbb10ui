package com.eltonkola.bb10ui.slide;

class MenuItem {

    public static final int NO_ICON = -1;
	private String name;
    private String description;
    private int icon = NO_ICON;
    private boolean new_icon;
    private int new_nr=0;
    
    private int id;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public boolean isNew_icon() {
		return new_icon;
	}
	public void setNew_icon(boolean new_icon) {
		this.new_icon = new_icon;
	}
	public int getNew_nr() {
		return new_nr;
	}
	public void setNew_nr(int new_nr) {
		this.new_nr = new_nr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}