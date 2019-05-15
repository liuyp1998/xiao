card_list = []

def show_menu():
    """显示菜单"""
    print("*" * 50)
    print("")
    print("1. 新增名片")
    print("2. 显示全部")
    print("3. 搜索名片")

    print("0. 退出系统")
    print("*" * 50)

def new_card():
    """新建名片"""
    print("-" * 50)
    print("新增名片")
    # 1提示用户输入信息
    name_str = input("请输入姓名: ")
    phone_str = input("请输入手机号: ")
    qq_str = input("请输入qq: ")
    email_str = input("请输入邮箱: ")
    # 2将用户信息建立为一个字典
    card_dict = {"name": name_str,
                 "phone": phone_str,
                 "qq": qq_str,
                 "email": email_str}
    # 3将字典的内容添加到列表
    card_list.append(card_dict)
    # print(card_list)
    # 4提示用户添加成功
    print("%s 添加成功" % name_str)

def show_all():
    """ 查询所有名片"""
    print("查询名片")
    print("-" * 50)
    # 打印表头
    if len(card_list) == 0:
        print("当前没有任何信息,请先新增信息 !")
    # return
    else:
        for name in ["姓名", "电话", "qq", "邮箱"]:
            print(name, end="\t\t")
        print(" ")
        # 打印分割线
        print("=" * 50)
        for card_dict in card_list:
            print("%s\t\t%s\t\t%s\t\t%s\t\t" % (card_dict["name"],
                                                card_dict["phone"],
                                                card_dict["qq"],
                                                card_dict["email"]))
            print(" ")

def search_card():
    """修改名片"""
    print("-" * 50)
    print("修改名片")
    # 1提示用户输入查找的内容
    find_name = input("请输入要查找的姓名: ")
    # 2根据用户输入的然后循环遍历查询列表内容
    for card_dict in card_list:
        if card_dict["name"] == find_name:
            print("=" * 50)
            print("%s\t\t%s\t\t%s\t\t%s\t\t" % (card_dict["name"],
                                                card_dict["phone"],
                                                card_dict["qq"],
                                                card_dict["email"]))
            #  针对找到的名片记录执行修改和删除操作
            deal_card(card_dict)
            break
    else:
        print("抱歉没有找到 %s " % find_name)


def deal_card(find_dict):
    """
    数据操作具体内容 1修改 2删除
    :param find_dict:查找到的函数
    """
    action_str = input("请选择要执行的操作 1修改 2删除 0 返回")
    if action_str == "1":
        find_dict["name"]  = input_card_info(find_dict["name"], "姓名: ")
        find_dict["phone"] = input_card_info(find_dict["phone"], "电话: ")
        find_dict["qq"] = input_card_info(find_dict["qq"], "qq: ")
        find_dict["email"] = input_card_info(find_dict["email"] , "邮箱")
        print("修改")
    elif action_str == "2":
        card_list.remove(find_dict)
        print("删除名片成功")

def input_card_info(dict_value, tip_message):
    """
回车返回上次的值
    :param dict_value: 传递信息
    :param tip_message: 提示信息
    :return:
    """
    # 1.提示用户输入内容
    result_str = input(tip_message)
    # 2.针对用户的输入进行判断,如果用户输入了内容,直接返回结果
    if len(result_str) > 0:
        return result_str
    # 3. 如果用户没有输入内容,返回字典原有的值
    else:
        return dict_value

