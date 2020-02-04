























drop table auction_parameter;

CREATE TABLE auction_parameter
(
    id bigserial not null,
    auction_id   bigint NOT NULL,
    parameter_id bigint not null,
    value varchar not null,
    PRIMARY KEY (id),
    foreign key (auction_id) references auction(id),
    foreign key (parameter_id) references parameter(id)
);
