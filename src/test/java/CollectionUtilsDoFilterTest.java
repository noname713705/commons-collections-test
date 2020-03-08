import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class CollectionUtilsDoFilterTest {
	@Test
	public void testCollectionUtilsDotFilterWhenIsNotBlank() {
		String[] values = {"someValue"};
		for(String value : values) {
			Collection<String> theCollection = Collections.singleton(value);
			try {
				CollectionUtils.filter(theCollection, StringUtils::isNotBlank);
				assertTrue(CollectionUtils.isNotEmpty(theCollection));
			} catch(UnsupportedOperationException uoe) {
				fail("should not fail for value=\""+value+"\"");
			}
		}
	}
	@Test
	public void testCollectionUtilsDotFilterWhenIsBlank() {
		String[] values = {" ","", null};
		for(String value : values) {
			Collection<String> theCollection = Collections.singleton(value);
			try {
				CollectionUtils.filter(theCollection, StringUtils::isNotBlank);
				System.out.println("CollectionUtils.filter should not fail for singleton value=\""+value+"\"");
				assertTrue(CollectionUtils.isEmpty(theCollection));
			} catch(UnsupportedOperationException uoe) {
				fail("should not fail for singleton value=\""+value+"\"");
			}
		}
	}

}
