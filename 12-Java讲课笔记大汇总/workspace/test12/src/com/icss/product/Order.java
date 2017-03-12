package com.icss.product;

/**
 * 订单类
 * @author Administrator
 *
 */
public class Order {
	
	public Customer c = new Customer();
	
	public Product p1 = new Product();
	public Product p2 = new Product();
	public Product p3 = new Product();
	
	double sumPrice;

	/**
	 * 订单信息
	 */
	public void getInformation() {
		sumPrice=0;
		System.out.println("客户名\t商品名\t\t单价\t数量\t价格");
		if (p1.getCount() != 0)
			System.out.println(c.getName() + "\t" + p1.getName() + "\t"
					+ p1.getPrice() + "\t" + p1.getCount() + "\t"
					+ this.getPrice(p1));
		
		if (p2.getCount() != 0)
			System.out.println(c.getName() + "\t" + p2.getName() + "\t"
					+ p2.getPrice() + "\t" + p2.getCount() + "\t"
					+ this.getPrice(p2));
		
		if (p3.getCount() != 0)
			System.out.println(c.getName() + "\t" + p3.getName() + "\t\t"
					+ p3.getPrice() + "\t" + p3.getCount() + "\t"
					+ this.getPrice(p3));
		
		System.out.println("总价格:" + this.sumPrice);
		System.out.println("送货地址:" + c.getAddress());
		System.out.println("电话：" + c.getTel());
		System.out.println();
		
	}

	/**
	 * 计算总价格
	 * @param p
	 * @return
	 */
	public double getPrice(Product p) {
		sumPrice += p.getPrice() * p.getCount();
		return p.getPrice() * p.getCount();
	}
	
}