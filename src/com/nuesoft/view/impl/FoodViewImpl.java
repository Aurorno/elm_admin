package com.nuesoft.view.impl;

import com.nuesoft.dao.FoodDao;
import com.nuesoft.dao.impl.FoodDaoImpl;
import com.nuesoft.po.Food;
import com.nuesoft.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {

    //注入数据访问层对象
    FoodDao foodDao = new FoodDaoImpl();
    //键盘接收对象
    private Scanner input = new Scanner(System.in);

    @Override
    public List<Food> showFoodList(Integer businessId) {
        List<Food> list = foodDao.listFoodByBusinessId(businessId);
        System.out.println("食品编号\t食品名称\t食品介绍\t食品价格");
        for(Food food : list) {
            System.out.println(food.getFoodId()+"\t"+food.getFoodName()+"\t"+food.getFoodExplain()+"\t"+food.getFoodPrice());
        }
        return list;
    }

    @Override
    public void saveFood(Integer businessId) {
        Food food = new Food();
        System.out.println("请输入食品名称：");
        food.setFoodName(input.next());
        System.out.println("请输入食品介绍：");
        food.setFoodExplain(input.next());
        System.out.println("请输入食品价格：");
        food.setFoodPrice(input.nextDouble());
        food.setBusinessId(businessId);
        int result = foodDao.saveFood(food);
        if(result>0) {
            System.out.println("\n新增食品成功！\n");
        }else {
            System.out.println("\n新增食品失败！\n");
        }
    }

    @Override
    public void updateFood(Integer businessId) {
        List<Food> list = showFoodList(businessId);
        if(list.size()==0) {
            System.out.println("没有任何食品！");
        }else {
            System.out.println("请选择要更新的食品编号：");
            int foodId = input.nextInt();
            Food food = foodDao.getFoodById(foodId);
            System.out.println(food);

            String inputStr = "";
            System.out.println("是否更新食品名称(y/n)：");
            inputStr = input.next();
            if(inputStr.equals("y")) {
                System.out.println("请输入新的食品名称：");
                food.setFoodName(input.next());
            }
            System.out.println("是否更新食品介绍(y/n)：");
            inputStr = input.next();
            if(inputStr.equals("y")) {
                System.out.println("请输入新的食品介绍：");
                food.setFoodExplain(input.next());
            }
            System.out.println("是否更新食品价格(y/n)：");
            inputStr = input.next();
            if(inputStr.equals("y")) {
                System.out.println("请输入新的食品价格：");
                food.setFoodPrice(input.nextDouble());
            }
            int result = foodDao.updateFood(food);
            if(result>0) {
                System.out.println("\n修改食品成功！\n");
            }else {
                System.out.println("\n修改食品失败！\n");
            }
        }
    }

    @Override
    public void removeFood(Integer businessId) {
        List<Food> list = showFoodList(businessId);
        if(list.size()==0) {
            System.out.println("没有任何食品！");
        }else {
            System.out.println("请选择要删除的食品编号：");
            int foodId = input.nextInt();

            System.out.println("确认要删除吗(y/n)：");
            if(input.next().equals("y")) {
                int result = foodDao.removeFood(foodId);
                if(result>0) {
                    System.out.println("\n删除食品成功！\n");
                }else {
                    System.out.println("\n删除食品失败！\n");
                }
            }
        }
    }
}
