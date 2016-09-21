package com.katruk.veiw;

import com.katruk.model.entity.Device;
import com.katruk.model.entity.Devices;

public class Renderer {

	/**
	 * print data
	 * @param string	input string
	 */
	public void show(String string){
		System.out.print(string);
	}

	/**
	 * print data with new line
	 * @param string	input string
	 */
	public void showLn(String string){
		System.out.println(string);
	}

	/**
	 * show devices
	 * @param devices	devices
	 */
	public void showDevises(Devices devices){
		for(Device device : devices.getDevice()){
			System.out.println(device);
		}
	}
}
