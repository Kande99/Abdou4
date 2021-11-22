package com.saraya.SpringBoot2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;



@Service //-> stereotype annotation and there are 4 : Controller, Repository, Service and Component
public class TireService {

	private static ArrayList<Tire> tires=new ArrayList<Tire>();
	private static int count=10;
	
	static {
		tires.add(new Tire(1,2019,"HIGHWAY","SUV","https://images.unsplash.com/photo-1579044924785-6fdd8ef713b1?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=387&q=80"));
		tires.add(new Tire(2,2017,"RIBBED","PERFORMANCE","https://c.wallhere.com/photos/32/55/Alfa_Romeo_2017_4C_Spider_USA_version_netcarshow_netcar_car_images_car_photo-367275.jpg!d"));
		tires.add(new Tire(3,2021,"ALL-PURPOSE","TOURING3","https://picolio.auto123.com/auto123tv/images/cs/sp/Bridgestone-EP-422-Plus_009.JPG?scaledown=980"));
		tires.add(new Tire(4,2021,"ALL SEASON","MINIVANS","https://img3.ouedkniss.com/photos_annonces/25038800/Min_large.jpg"));
		tires.add(new Tire(5,2021,"MUD-TERRAIN","Turbo","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSg5JxNSy9ceuKdrYzDIbrV2GeOW05PKLfUy_SOHHNRiHGeI5oRgJgB2iPxNExAhAg3JLI&usqp=CAU"));
		tires.add(new Tire(6,2020,"ALL-TERRAIN","SEDANS","https://image.made-in-china.com/202f0j10IwVEdlerbcpG/Made-in-China-Tyre-Manufacturer-Cheap-New-Radial-Passenger-Car-Tire-with-All-Certificates.jpg"));
		tires.add(new Tire(7,2020,"SPORT-TRUCK","ATV","http://bsg-i.nbxc.com/product/99/82/dd/6b9fc68ad10d4b7527af8f133c.jpg@4e_500w_500h.src%7Cwatermark=2&text=ZnIuZnl0aXJlcy5jb20%3D&t=75&color=I0ZGRkZGRg%3D%3D&size=35&p=9%7C95Q.webp"));
		tires.add(new Tire(8,2020,"WINTER","UTV","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0pJPU3-pDdZ6PIT3YCXAFP3ntlJp-maR6lA&usqp=CAU"));
		tires.add(new Tire(9,2020,"TEMPORY SPARES","STUDDLESS","https://www.easywheels.co.uk/images/model/Fulda-Carat-Extremo.jpg"));
		tires.add(new Tire(10,2020,"TRAILER","195/55R","https://blog.allopneus.com/wp-content/uploads/2010/11/fulda.jpg"));
	}
	
	public List<Tire> getAllTires(){
		return tires;
	}
	public void addTire(int year, String make, String model,String image) {
		tires.add(new Tire(++count,year,make,model,image));
	}
	public void deleteTire(int id) {
		Iterator<Tire> iterate=tires.iterator();
		while(iterate.hasNext()) {
			Tire tire=iterate.next();
			if(tire.getId()==id) {
				iterate.remove();
	}
	
}
}
	public Tire findById(int id) {
	for(Tire t:tires) {
		if(t.getId()==id) {
			return t;
		}
	}
	return null;
}
	public void updateByTire(Tire t) {
		tires.remove(t);
		tires.add(t);
	}
}