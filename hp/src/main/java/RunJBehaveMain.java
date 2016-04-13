
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;

import hashproject.hp.Hash;

public class RunJBehaveMain {

	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("HashStory.story", "HashStory2.story", "HashStory3.story", "HashStory4.story", "HashStory5.story",
												"HashStory6.story", "HashStory7.story");
	
	public static void main(String[] args) {
		embedder.configuration().useStoryLoader(new LoadFromClasspath())
		  .useStoryReporterBuilder(new StoryReporterBuilder()
				  .withDefaultFormats() 
				    .withFormats(Format.CONSOLE, Format.TXT));
		embedder.candidateSteps().add(new MySteps());
		embedder.runStoriesAsPaths(storyPaths);
	
		/*Hash hash = new Hash();
		for(int i=0; i<11; i++) {
			hash.addInt(5);
		}*/
	}
}
