package config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.seasar.doma.jdbc.tx.LocalTransaction;
import org.seasar.doma.jdbc.tx.LocalTransactionalDataSource;

import config.logger.DomaLogbackLogger;

/**
 * <p>
 * データベースの接続情報です。
 * </p>
 *
 * @author toshiya
 *
 */
public class DataBaseConfig extends DomaAbstractConfig {

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.sql.DataSource
	 */
	@Resource(lookup = "java:jboss/datasources/jboss-javaee6-webappDS")
	private DataSource dataSource;

	private Dialect dialect;

	private static DomaLogbackLogger domaLogbakLogger;

	/**
	 * コンストラクタ
	 */
	public DataBaseConfig() {
		super();
		dialect = new PostgresDialect();
		domaLogbakLogger = new DomaLogbackLogger();
	}

	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public Dialect getDialect() {
		// TODO ファクトリクラスを作成してjdbcdriverclassnameを正規表現でマッチさせてダイアレクトを変更する
		// MysqlDialect
		// PostgresDialect
		// OracleDialect
		return dialect;
	}

	public LocalTransaction getLocalTransaction() {
		return new LocalTransactionalDataSource(dataSource)
				.getLocalTransaction(defaultJdbcLogger);
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see org.seasar.doma.jdbc.DomaAbstractConfig#getJdbcLogger()
	 */
	@Override
	public JdbcLogger getJdbcLogger() {
		return domaLogbakLogger;
	}

	/**
	 * <p>
	 * トランザクションが開始されていない場合にトランザクションを開始します。
	 * </p>
	 * DataSouceがnullの場合や{@link LocalTransaction#isActive()}が「true」の場合は何も実行しません。
	 */
	public void begin() {
		if (dataSource != null) {
			LocalTransaction localTransaction = this.getLocalTransaction();
			if (!localTransaction.isActive()) {
				localTransaction.begin();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object paramObject) {
		return EqualsBuilder.reflectionEquals(this, paramObject);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
