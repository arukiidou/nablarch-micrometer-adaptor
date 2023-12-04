package nablarch.integration.micrometer.otlp;

import io.micrometer.registry.otlp.OtlpConfig;
import nablarch.core.repository.di.DiContainer;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThrows;

/**
 * {@link NablarchOtlpConfig}の単体テスト。
 * @author Junya Koyama
 */
public class NablarchOtlpConfigTest {

    @Test
    public void testSubPrefix() {
        NablarchOtlpConfig sut = new NablarchOtlpConfig(null, null);
        // From NablarchOtlpConfig
        assertThat(sut.subPrefix(), is("otlp"));
    }

    /**
     * {@link nablarch.integration.micrometer.NablarchMeterRegistryConfig}のデフォルト値テスト。
     */
    @Test
    public void testDefaultFromNablarchMeterRegistryConfig() {
        NablarchOtlpConfig sut = new NablarchOtlpConfig(null, null);
        assertThat(sut.prefix(), is(String.join(".", "nablarch.micrometer", sut.subPrefix())));
        assertThat(sut.prefix(), is("nablarch.micrometer.otlp"));
    }

    /**
     * {@link io.micrometer.registry.otlp.OtlpConfig}のデフォルト値テスト。
     */
    @Test
    public void testDefaultFromOtlpConfig() {
        // diContainerをnullにすると、NullPointerException
        NablarchOtlpConfig sut = new NablarchOtlpConfig(null, null);
        assertThrows(NullPointerException.class, sut::url);
    }
}
