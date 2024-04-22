select "order".id, "order".pick_point_id, "order".date,
"order".sum, "order".client_id, order_list.id as "items"
from "order"
join order_list ON order_list.order_id = "order".id
where "order".id=3