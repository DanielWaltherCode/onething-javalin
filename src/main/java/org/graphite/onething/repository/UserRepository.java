package org.graphite.onething.repository;

import org.graphite.onething.DataConnection;
import org.graphite.onething.tables.pojos.UserTable;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.graphite.onething.Tables.USER_TABLE;

public class UserRepository {
    private final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);
    private final DSLContext dslContext;

    public UserRepository() {
        DataConnection dataConnection = new DataConnection();
        dslContext = dataConnection.getDSL();
    }

    public UserTable getUser(Integer id) {
        return dslContext
                .select(USER_TABLE.ID, USER_TABLE.EMAIL)
                .from(USER_TABLE)
                .where(USER_TABLE.ID.eq(id))
                .fetchOneInto(UserTable.class);
    }
}
