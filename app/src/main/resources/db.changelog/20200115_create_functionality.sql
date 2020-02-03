









CREATE TABLE branch
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR   NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE parameter
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR   NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE category
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR   NOT NULL,
    branch_id BIGINT not null,

    PRIMARY KEY (id),
    foreign key (branch_id) references branch(id)
);

CREATE TABLE photo
(
    id   BIGSERIAL NOT NULL,
    link VARCHAR   NOT NULL,


    PRIMARY KEY (id)
);



CREATE TABLE auction
(
    id   BIGSERIAL NOT NULL,
    category_id bigint   NOT NULL,
    title VARCHAR   NOT NULL,
    description VARCHAR   NOT NULL,
    price numeric(9,2)   NOT NULL,
    owner_username varchar not null,
    photo_id bigint not null,

    PRIMARY KEY (id),
    foreign key (category_id) references category(id),
    foreign key (owner_username) references profile(username),
    foreign key (photo_id) references photo(id)
);


CREATE TABLE auction_parameter
(
    auction_id   bigint NOT NULL,
    parameter_id bigint not null,
    value varchar not null,

    PRIMARY KEY (auction_id),
    foreign key (auction_id) references auction(id),
    foreign key (parameter_id) references parameter(id)
);

























