select queries.orders.product_name from queries.orders
join queries.customers ON queries.customers.id = queries.orders.customer_id
where queries.customers.name = :name;

