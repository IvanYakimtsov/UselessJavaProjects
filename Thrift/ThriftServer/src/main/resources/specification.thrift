namespace java com.yakimtsov.thrift

struct Item {
  1: string title,
  2: string content,
}

service CrawlingService {
    void addItem(1:list<Item> items),
	list<Item> getItems(),
	void modifyItem(1:Item oldItem, 2:Item newItem),
	void deleteItem(1:Item item),
}