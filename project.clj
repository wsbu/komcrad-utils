(defproject komcrad-utils "0.9.0"
  :description "komcrad's utilities"
  :url "https://github.com/wsbu/komcrad-utils"
  :license {:name "GNU Lesser General Public License"
            :url "https://www.gnu.org/licenses/lgpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :deploy-repositories [["releases" {:url "https://mvn.redlion.net/repository/maven-releases"
                                     :sign-releases false}]
                        ["snapshots" {:url "https://mvn.redlion.net/repository/maven-snapshots"
                                      :sign-releases false}]])
