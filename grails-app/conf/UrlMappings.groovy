class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/"(redirect: "/quickStart/landing")
		"500"(view:'/error')
	}
}
